package Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> persons;


    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.persons = new ArrayList<>();
    }


    public void add(Person person) {
        if (getCount() < capacity) {
            persons.add(person);
        }
    }

    public int getCount() {
        return persons.size();
    }

    public boolean remove(String name) {

        for (Person p : persons) {
            if (name.equals(p.getName())) {
                persons.remove(p);
                return true;
            }
        }
       return false;
        }


    public Person getPerson(String name, String hometown) {
        for (Person p:persons) {
            if(name.equals(p.getName())&& hometown.equals(p.getHometown())){
                return p;
            }
        }
        return null;
    }

    public String getStatistics() {
      return persons.stream()
               .map(p -> String.format("The people in the hotel %s are:%n" +
                       "Person %s: %d, Age: %d, Hometown: %s",this.name,p.getName(),p.getId(),p.getAge(),p.getHometown()))
              .collect(Collectors.joining(System.lineSeparator()));
    }
}
