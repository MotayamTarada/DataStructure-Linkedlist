package application;

import java.io.*;
import java.util.Iterator;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CircularLinkedList<T extends Comparable<T>> {

	private Node head;
	private Node tail;
	private int size;

	public CircularLinkedList() {
		head = tail = null;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void addAtHead(T data) {
		Node<T> newNode = new <T>Node(data);

		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}

		size++;
	}

	public void display() {
		if (head == null) {
			System.out.println("Circular Linked List is empty");
			return;
		}
		Node<T> current = head;
		do {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		} while (current != head);
		System.out.println();
	}

	public void addSorted(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			newNode.setNext(head);
		} else if (data.compareTo((T) head.getData()) < 0) {
			newNode.setNext(head);
			Node<T> temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			head = newNode;
		} else {
			Node<T> curr = head;
			while (curr.getNext() != head && data.compareTo(curr.getNext().getData()) > 0) {
				curr = curr.getNext();
			}
			newNode.setNext(curr.getNext());
			curr.setNext(newNode);
		}
		size ++;
	}

	
	public void delete(T data) {
	    Text err = new Text("List is empty");
	    err.setFont(Font.font("Arial", FontWeight.BOLD, 20));

	    if (head == null) {
	        Main.massegeBox(err);
	        return; // Exit the method if the list is empty
	    }

	    Node<T> current = head;
	    Node<T> prev = null;
	    boolean found = false;

	    // Search for the node to delete
	    do {
	        if (current.getData().equals(data)) {
	            found = true;
	            break;
	        }
	        prev = current;
	        current = current.getNext();
	    } while (current != head);

	    if (found) {
	        // Deletion logic based on different cases
	        if (head == current && head.getNext() == head) {
	            head = null; // Only one node in the list
	        } else if (head == current) {
	            Node<T> temp = head;
	            while (temp.getNext() != head) {
	                temp = temp.getNext();
	            }
	            temp.setNext(head.getNext());
	            head = head.getNext();
	        } else {
	            prev.setNext(current.getNext());
	        }
	    } else {
	        System.out.println("Node with given data not found");
	        // Handle case when the node to delete is not found
	        // You can throw an exception, show an error message, etc., based on your application's needs
	    }
	}


	// Method to update a node's value in the circular linked list
	public void update(T oldData, T newData) {
		if (head == null) {
			return;
		}
		Node<T> current = head;
		do {
			if (current.getData() == oldData) {
				current.setData(newData);
				break;
			}
			current = current.getNext();
		} while (current != head);
	}

	// search Element
	public Node<T> search(T data) {
		if (head == null) {
			return null;
		}

		Node<T> curr = head;

		do {
			T currData = curr.getData();
			if (currData != null && currData.compareTo(data) == 0) {
				return curr;
			}
			curr = curr.getNext();
		} while (curr != head);

		return null; // Element not found in the circular linked list
	}

	public void addLast(T data) {
		Node newNode = new Node(data);

		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public boolean isEmpty() {
		return head == null; // If the head is null, the list is empty
	}

	public void concatenate(CircularLinkedList<T> listToConcatenate) {
		if (listToConcatenate.head == null) {
			return;
		}
		Node<T> temp = listToConcatenate.head;
		do {
			addSorted(temp.getData());
			temp = temp.getNext();
		} while (temp != listToConcatenate.head);
	}

	public static void printAll(CircularLinkedList<Electricity> list, CircularLinkedList<Electricity> list2,
			CircularLinkedList<Electricity> list3) {
		Node<Electricity> curr = list.getHead();
		Node<Electricity> curr2 = list2.getHead();
		Node<Electricity> curr3 = list3.getHead(); // Assuming list3 is the third CircularLinkedList

		// Check if all lists are not empty
		if (curr != null && curr2 != null && curr3 != null) {
			Node<Electricity> temp = curr;
			Node<Electricity> temp2 = curr2;
			Node<Electricity> temp3 = curr3;

			do {
				System.out.println("year=" + ((Electricity) temp.getData()).getYear() + " , " + "month="
						+ ((Electricity) temp2.getData()).getMonth() + " , "
						+ ((Electricity) temp3.getData()).toString());

				temp = temp.getNext(); // Move to the next node in list
				temp2 = temp2.getNext(); // Move to the next node in list2
				temp3 = temp3.getNext(); // Move to the next node in list3
			} while (temp != curr && temp2 != curr2 && temp3 != curr3); // Loop until a cycle is completed in all lists
		}
	}


	
	public Object getData(int index) {
	    if (index < 0 || isEmpty()) {
	        return null; // Return null for invalid index or empty list
	    }

	    Node current = getHead();
	    int currentIndex = 0;

	    while (current != null) {
	        if (currentIndex == index) {
	            return current.getData(); // Return data when index is found
	        }
	        current = current.getNext();
	        currentIndex++;
	    }

	    return null; // Return null if index is out of bounds
	}


// Statistics Sceen 
//--------------------------------------------------------------------------------

	
	
	public double curr_Avg_Year(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int year) {
	    int sum = 0;
	    int count = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getYear();

	            if (y == year) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    sum += total.getTotal_daily_Supply_available_in_MWs()*365;
	                    count++;
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return count > 0 ? (double) sum / count : 0;
	    }
	}
	public double curr_Sum_Year(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int year) {
	    int sum = 0;
	    int count = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getYear();

	            if (y == year) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    sum += total.getTotal_daily_Supply_available_in_MWs()*365;
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return (double) sum;
	    }
	}
	
	public double curr_Max_Year(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int year) {
	    double max = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getYear();

	            if (y == year) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    double tot =total.getTotal_daily_Supply_available_in_MWs()*365;
	                    if(tot>max) {
	                    	max=tot;
	                    }
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return max;
	    }
	}
	
	public double curr_Min_Year(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int year) {
	    double min = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getYear();

	            if (y == year) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    double tot =total.getTotal_daily_Supply_available_in_MWs()*365;
	                    if(tot<min) {
	                    	min=tot;
	                    }
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return min;
	    }
	}


  //----------------------Month--------------------------------------------------------
	public double curr_Avg_Month(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int month) {
	    int sum = 0;
	    int count = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getMonth();

	            if (y == month) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    sum += total.getTotal_daily_Supply_available_in_MWs()*30;
	                    count++;
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return count > 0 ? (double) sum / count : 0;
	    }
	}
	public double curr_Sum_Month(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int month) {
	    int sum = 0;
	    int count = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getMonth();

	            if (y == month) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    sum += total.getTotal_daily_Supply_available_in_MWs()*30;
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return (double) sum;
	    }
	}
	
	public double curr_Max_Month(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int month) {
	    double max = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getMonth();

	            if (y == month) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    double tot =total.getTotal_daily_Supply_available_in_MWs()*30;
	                    if(tot>max) {
	                    	max=tot;
	                    }
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return max;
	    }
	}
	
	public double curr_Min_Month(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int month) {
	    double min = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getMonth();

	            if (y == month) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    double tot =total.getTotal_daily_Supply_available_in_MWs()*30;
	                    if(tot<min) {
	                    	min=tot;
	                    }
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return min;
	    }
	}
  //-----------------------------day------------------------------------------------
	public double curr_Avg_Day(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int day) {
	    int sum = 0;
	    int count = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getDaye();

	            if (y == day) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    sum += total.getTotal_daily_Supply_available_in_MWs();
	                    count++;
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return count > 0 ? (double) sum / count : 0;
	    }
	}
	public double curr_Sum_Day(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int day) {
	    int sum = 0;
	    int count = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getDaye();

	            if (y == day) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    sum += total.getTotal_daily_Supply_available_in_MWs();
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return (double) sum;
	    }
	}
	
	public double curr_Max_Day(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int day) {
	    double max = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getDaye();

	            if (y == day) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    double tot =total.getTotal_daily_Supply_available_in_MWs();
	                    if(tot>max) {
	                    	max=tot;
	                    }
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return max;
	    }
	}
	
	public static void printFile(CircularLinkedList<Electricity> list, CircularLinkedList<Electricity> list2,
			CircularLinkedList<Electricity> list3, File file) throws FileNotFoundException {
		StringBuilder str = new StringBuilder();
		PrintWriter data = new PrintWriter(file);
		Node<Electricity> curr = list.getHead();
		Node<Electricity> curr2 = list2.getHead();
		Node<Electricity> curr3 = list3.getHead(); // Assuming list3 is the third CircularLinkedList
		try {
			// Check if all lists are not empty
			if (curr != null && curr2 != null && curr3 != null) {
				Node<Electricity> temp = curr;
				Node<Electricity> temp2 = curr2;
				Node<Electricity> temp3 = curr3;

				do {
					str.append("year=" + ((Electricity) temp.getData()).getYear() + " , " + "month="
							+ ((Electricity) temp2.getData()).getMonth() + " , "
							+ ((Electricity) temp3.getData()).toString() + "\n");
					data.write(str + "");

					temp = temp.getNext(); // Move to the next node in list
					temp2 = temp2.getNext(); // Move to the next node in list2
					temp3 = temp3.getNext(); // Move to the next node in list3
				} while (temp != curr && temp2 != curr2 && temp3 != curr3); // Loop until a cycle is completed in all
																			// lists
			}
		} catch (Exception e) {
		}

		
	}
	
	public double curr_Min_Day(CircularLinkedList<Electricity> list1, CircularLinkedList<Electricity> list3, int day) {
	    double min = 0;

	    if (list1.isEmpty()) {
	        return -1;
	    } else {
	        Node<Electricity> current = list1.getHead(); // Assuming the circular linked list has a getHead() method

	        for (int i = 0; i < list1.size; i++) {
	            Electricity a = current.getData();
	            int y = a.getDaye();

	            if (y == day) {
	                Node<Electricity> currentList3 = list3.getHead(); // Assuming the circular linked list has a getHead() method

	                for (int j = 0; j < list3.size; j++) {
	                    Electricity total = currentList3.getData();
	                    double tot =total.getTotal_daily_Supply_available_in_MWs()*30;
	                    if(tot<min) {
	                    	min=tot;
	                    }
	                    
	                    currentList3 = currentList3.getNext();
	                }
	            }
	            current = current.getNext();
	        }
	        return min;
	    }
	}
	

	// ------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", size=" + size + "]";
	}	

}
