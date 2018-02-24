package DataManagement;


public class Person
{
    private String name;
    private String[] positions;
    private int id;
    private int pin;

    public Person(String name, int id, String[] positions,int pin, String filename)
    {
        this.name = name;
        this.id = id;
        this.positions = positions;
        this.pin = pin;

        DataManager dm = new DataManager(filename);
        dm.addPerson(this);
    }
    public Person(String name, int id, String[] positions,int pin, DataManager dm)
    {
        this.name = name;
        this.id = id;
        this.positions = positions;
        this.pin = pin;

        dm.addPerson(this);
    }

    public String toString(){
        return this.name+","+String.valueOf(this.id);
    }

    public String saveString(){
        String output = "\""+this.name+"\",";
        output += String.valueOf(this.id)+",[";
        for(int i = 0; i < positions.length-1; i++){
            output += positions[i];
            output += "\";";
        }
        output += "\""+positions[positions.length-1]+"\"],";
        output += this.pin;
        return output;
    }

    public String getName(){
        return this.name;
    }

    public String[] getPositions(){
        return this.positions;
    }

    public int getId(){
        return this.id;
    }

    public boolean comparePin(int pin){
        return (this.pin == pin);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPin(){
        this.pin = pin;
    }

    public void addPosition(String position){
        for(int i = 0; i < this.positions.length; i++){
            if(position == this.positions[i]) return;
        }

        String[] newpos = new String[this.positions.length+1];
        for(int i = 0; i < this.positions.length; i++) {
            newpos[i] = this.positions[i];
        }

        newpos[newpos.length-1] = position;
        this.positions = newpos;
    }

}
