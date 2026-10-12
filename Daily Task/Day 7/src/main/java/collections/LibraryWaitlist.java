package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class LibraryWaitlist {

    // Lower priority number means a more important request.
    record LibraryRequest(String name, int priority) {
    }

    public static void main(String[] args) {

        // ArrayList: preserves catalogue order and supports indexed access.
        List<String> catalogue = new ArrayList<>();
        catalogue.add("Java Programming");
        catalogue.add("Database Systems");
        catalogue.add("Spring Boot");
        catalogue.add("Java Programming");

        System.out.println("1. Library Catalogue (ArrayList):");
        System.out.println(catalogue);

        // LinkedHashSet: removes duplicates while preserving insertion order.
        Set<String> uniqueBooks = new LinkedHashSet<>(catalogue);
        System.out.println("\n2. Unique Books (LinkedHashSet):");
        System.out.println(uniqueBooks);

        // HashSet: useful for uniqueness when iteration order is not required.
        Set<String> studentIds = new HashSet<>();
        studentIds.add("S103");
        studentIds.add("S101");
        studentIds.add("S103");
        System.out.println("\n3. Unique Student IDs (HashSet):");
        System.out.println(studentIds);

        // TreeSet: stores unique values in sorted order.
        Set<String> sortedBooks = new TreeSet<>(catalogue);
        System.out.println("\n4. Sorted Books (TreeSet):");
        System.out.println(sortedBooks);

        // ArrayDeque: efficient FIFO queue for ordinary waitlist requests.
        Queue<String> waitlist = new ArrayDeque<>();
        waitlist.offer("Student A");
        waitlist.offer("Student B");
        waitlist.offer("Student C");

        System.out.println("\n5. Waitlist (ArrayDeque):");
        System.out.println(waitlist);
        System.out.println("Next student: " + waitlist.poll());
        System.out.println("Remaining: " + waitlist);

        // PriorityQueue: lower priority number is processed first.
// Faculty has priority 1; students have priority 2.
        Queue<LibraryRequest> priorityRequests =
                new PriorityQueue<>(
                        java.util.Comparator.comparingInt(
                                LibraryRequest::priority
                        )
                );

        priorityRequests.offer(new LibraryRequest("Student B", 2));
        priorityRequests.offer(new LibraryRequest("Faculty A", 1));
        priorityRequests.offer(new LibraryRequest("Student C", 2));

        System.out.println("\n6. Priority Requests:");
        while (!priorityRequests.isEmpty()) {
            LibraryRequest request = priorityRequests.poll();
            System.out.println(
                    request.name() + " (priority " + request.priority() + ")"
            );
        }

        // Iterator.remove: safely remove overdue books during iteration.
        List<String> borrowedBooks = new ArrayList<>(
                List.of("Java Programming", "Overdue: DBMS", "Spring Boot",
                        "Overdue: Networking")
        );

        Iterator<String> iterator = borrowedBooks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith("Overdue:")) {
                iterator.remove();
            }
        }

        System.out.println("\n7. After removing overdue books:");
        System.out.println(borrowedBooks);

        // ListIterator: supports forward and backward traversal and modification.
        List<String> tasks = new ArrayList<>(
                List.of("Register student", "Issue book")
        );

        var listIterator = tasks.listIterator();
        while (listIterator.hasNext()) {
            String task = listIterator.next();
            if (task.equals("Issue book")) {
                listIterator.set("Issue library book");
            }
        }

        System.out.println("\n8. ListIterator result:");
        System.out.println(tasks);

        // LinkedList: supports operations at both ends, but indexed access is slower.
        List<String> linkedCatalogue = new LinkedList<>(catalogue);
        System.out.println("\n9. LinkedList catalogue:");
        System.out.println(linkedCatalogue);
    }
}