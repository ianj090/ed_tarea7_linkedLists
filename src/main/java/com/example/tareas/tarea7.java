package com.example.tareas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tarea7 {

    @RequestMapping("/list")
    public String print() {
        return LinkedList.listSongs();
    }

    @RequestMapping("/add")
    public String add(String song) {
        return LinkedList.addSong(song);
    }

    @RequestMapping("/play")
    public String play(String song) {
        return LinkedList.playNow(song);
    }

    @RequestMapping("/next")
    public String next() {
        return LinkedList.playNext();
    }

    @RequestMapping("/previous")
    public String prev() {
        return LinkedList.playPrev();
    }
}

class LinkedList {

    static LinkedList list = new LinkedList();
    Node head;
    static Node playing;

    static class Node {
        String data;
        Node next;
        Node prev;

        Node(String data_val) {
            prev = null;
            data = data_val;
            next = null;
        }
    }

    public static String listSongs() {
        Node current = list.head;
        String result = "";

        while (current != null) {
            result = result + current.data + "<br>";
            current = current.next;
        }
        if (result.equals("")) {
            return "No songs added";
        }
        return result;
    }

    public static String addSong(String name) {
        Node new_n = new Node(name);
        new_n.next = null;
        if (list.head == null) {
            list.head = new_n;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            new_n.prev = last;
            last.next = new_n;
        }
        return "Added Successfully";
    }

    public static String playNow(String name) {
        Node current = list.head;
        int count = 0;

        while (current != null) {
            if (current.data.equals(name)) {
                playing = current;
                count++;
            }
            current = current.next;
        }
        if (count == 1) {
            return "Playing: " + playing.data;
        }
        return "Song does not exist";
    }

    public static String playNext() {
        if (playing == null) {
            playing = list.head;
        }
        if (playing == null) {
            return "No songs added";
        }
        playing = playing.next;
        if (playing == null) {
            return "No more songs";
        }
        return "Playing: " + playing.data;
    }

    public static String playPrev() {
        if (playing == null) {
            playing = list.head;
        }
        if (playing == null) {
            return "No songs added";
        }
        playing = playing.prev;
        if (playing == null) {
            return "No more songs";
        }
        return "Playing: " + playing.data;
    }
}
