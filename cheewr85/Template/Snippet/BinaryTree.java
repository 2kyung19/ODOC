import java.util.*;
import java.io.*;

// 만약 트리에 입력 값이 있다면

// 트리에서 하나의 Node에 해당하는 클래스
class Node {
    char data;
    Node left;
    Node right;

    // 노드에 값이 할당되어 처리되므로 생성자를 통해 노드 data 선언
    Node(char data) {
        this.data = data;
    }
}

// 노드를 이어서 트리로 표현하기 위해 만든 클래스
class Tree {
    // 루트 노드 먼저 확인
    public Node root;

    // 노드 생성, 노드는 왼쪽 노드 오른쪽 노드가 있으므로 좌우값을 체크해서 노드로 생성함
    public void createNode(char data, char leftData, char rightData) {
        // root가 없는 초기 상태라면 루트 노드 생성함
        if (root == null) {
            root = new Node(data);

            // 좌우 값이 있는 경우에 노드 생성하여 할당
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            // 초기 상태가 아니면 루트 노드 이후 어디로 들어가야 할 지 찾음
            searchNode(root, data, leftData, rightData);
        }
    }

    // root 노드가 아닐 경우 들어갈 자리 탐색을 위해 노드 탐색후 노드 연결함
    public void searchNode(Node root, char data, char leftData, char rightData) {
        if (root == null) {
            // 도착한 노드가 null이면 재귀 종료, 넣을 노드가 없는 것이므로
            return;
        } else if (root.data == data) {
            // 들어갈 위치가 있다면 입력받은 root.data가 data면
            // 값이 있는 경우 노드 생성해서 할당
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            // 위에서 노드가 null인 경우와 root인 경우를 제외하고 들어갈 위치를 더 탐색하기 위해서 root 기준 왼쪽, 오른쪽에서 찾아서 연결(재귀로 구현)
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }
}