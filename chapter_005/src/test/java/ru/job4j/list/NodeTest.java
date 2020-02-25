package ru.job4j.list;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void whenHasCycleFourToFirst() {

        Node<Integer> first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        boolean expected = true;

        assertTrue(hasCircle(first));
    }

    @Test
    public void whenHasCycleTwoToFirst() {

        Node<Integer> first = new Node(1);
        Node two = new Node(2);

        first.next = two;
        two.next = first;


        boolean expected = true;

        assertTrue(hasCircle(first));
    }

    @Test
    @Ignore
    public void whenHasCycleThirdToTwo() {

        Node<Integer> first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);

        first.next = two;
        two.next = third;
        third.next = two;

        assertTrue(hasCircle(first));


        Node four = new Node(4);
        third.next = four;
        four.next = null;
        assertFalse(hasCircle(first));
    }

    @Test
    @Ignore
    public void whenHasCycleIsFalse() {

        Node<Integer> first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        assertFalse(hasCircle(first));
    }

    private static boolean hasCircle(Node first) {
        boolean result = false;      // по умолчанию, нет цикличности
        Node nodeNext = first;  // временный контейнер для операции сверки при прогоне элементов
        Node currentNode = nodeNext.next; // это маркер элементов. между элементом first и маркером будет осуществляться прогон
        int maxNode = 1; // максимальный индекс количества контейнеров, получаемое при переборе
        int countNode = 0; // текущий индекс количества контейнеров при итерации
//        if (currentNode == first) {
//            result = true;
//        }

        // делаем зацикливание, но предусматриваем внутренний выход из цикла, присвоив result = true;
        while (countNode < maxNode) {
            // если еще есть элементы, переходим к перебору
//            if  (countNode > maxNode) {
//                break;
//            }
            if (currentNode != null) {
                while (nodeNext != currentNode) {
                    nodeNext = nodeNext.next;
                    countNode++;
                    if (nodeNext == currentNode) {
//                        if (countNode < maxNode) {
//                            result = true;
//                            countNode = maxNode + 1;
//                            break;
//                        }
                        currentNode = currentNode.next;
                        nodeNext = first;
                        if (countNode == maxNode) {
                            maxNode++;
                            countNode = 0;
                        }

                    }


                }
                if (currentNode == nodeNext) {
                    result = true;
//                    countNode = maxNode + 1;
                    break;
                }
            } else {
                //  зацикливания нет. выходим
                break;
            }
        }
        return result;
    }
}