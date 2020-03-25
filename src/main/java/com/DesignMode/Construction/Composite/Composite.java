package com.DesignMode.Construction.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Composite {
    /**
     * 将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性
     * 优点：
     *  1、高层模块调用简单
     *  2、节点自由增加
     * 缺点：
     *  使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则
     */

    public static void main(String[] args) {
        Node html = new ElementNode("html");
        Node body = new ElementNode("body");
        html.add(body);
        body.add(new TextNode("Hello world!!!"));
        System.out.println(html.toHtml());
    }
}

interface Node {
    Node add(Node node);

    List<Node> children();

    String toHtml();
}

class ElementNode implements Node {
    private String name;
    private List<Node> list = new ArrayList<>();

    public ElementNode(String name) {
        this.name = name;
    }

    @Override
    public Node add(Node node) {
        list.add(node);
        return this;
    }

    @Override
    public List<Node> children() {
        return list;
    }

    @Override
    public String toHtml() {
        String start = "<" + name + ">\n";
        String end = "</" + name + ">\n";
        StringJoiner sj = new StringJoiner("", start, end);
        list.forEach(node -> {
            sj.add(node.toHtml());
        });
        return sj.toString();
    }
}

class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children() {
        return null;
    }

    @Override
    public String toHtml() {
        return text + "\n";
    }
}