public class Vertex {
    private People people;
    private int height;
    private Vertex Right, Left;
    private int Bal;

    Vertex(People data) {
        this.people = data;
        this.height = 1;
        this.Left = null;
        this.Right = null;
        this.Bal = 0;
    }

    public int getBal() {
        return Bal;
    }

    public void setBal(int bal) {
        Bal = bal;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Vertex getLeft() {
        return Left;
    }

    public Vertex getRight() {
        return Right;
    }

    public void setLeft(Vertex left) {
        Left = left;
    }

    public void setRight(Vertex right) {
        Right = right;
    }
}
