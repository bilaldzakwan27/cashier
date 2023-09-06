package com.smk.service;

import com.smk.User;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class UserService {
    FileWriter userServiceWriter;
    FileReader userServiceReader;
    List<User> userList = new LinkedList<User>();
    private static UserService userService = null;
    private UserService () {
        try {
            userServiceWriter = new FileWriter("user.txt");
            userServiceReader = new FileReader("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized UserService getInstance() {
        if(userService == null)
            userService = new UserService();
        return userService;

    }

    private void readFile(){
        BufferedReader bufferedReader = new BufferedReader(userServiceReader);
        List<String> stringList = bufferedReader.lines().toList();
        userList = new LinkedList<User>();
        for (String string:stringList){
            userList.add(parsingLineToUser(string));
        }
    }

    private void writeFile() {
        BufferedWriter bufferedWriter = new BufferedWriter(userServiceWriter);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(user.getUserName());
            sb.append("|");
            sb.append(user.getPassword());
            try {
                bufferedWriter.write(sb.toString());
                if (i < userList.size() - 1) {
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private User parsingLineToUser(String string){
        StringTokenizer st = new StringTokenizer(string, "|");
        int id = 0;
        User user = new User();
        while (st.hasMoreElements()){
            if (id == 0){
                user.setUserName(st.nextToken());
            } else if (id == 1) {
                user.setPassword(st.nextToken());
            }
            id++;
        }
        return user;
    }

    public List<User> getUserList() {
        readFile();
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
        writeFile();
    }
}
