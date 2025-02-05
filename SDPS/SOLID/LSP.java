public class LSP {
    static interface Shape {
        int getArea();
    }
    static class Rectangle implements Shape {
        protected int width;
        protected int height;
    
        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }
    
        @Override
        public int getArea() {
            return width * height;
        }
    }
    
    static class Square implements Shape {
        private int side;
    
        public Square(int side) {
            this.side = side;
        }
    
        @Override
        public int getArea() {
            return side * side;
        }
    }
    
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // Output: 50

        Shape square = new Square(5);
        System.out.println("Square Area: " + square.getArea()); // Output: 25
    }
}



//not following LSP

// class Rectangle {
//     protected int width;
//     protected int height;

//     public void setWidth(int width) {
//         this.width = width;
//     }

//     public void setHeight(int height) {
//         this.height = height;
//     }

//     public int getArea() {
//         return width * height;
//     }
// }

// class Square extends Rectangle {
//     @Override
//     public void setWidth(int width) {
//         super.setWidth(width);
//         super.setHeight(width); // Ensuring width and height are always equal
//     }

//     @Override
//     public void setHeight(int height) {
//         super.setWidth(height);
//         super.setHeight(height); // Ensuring width and height are always equal
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Rectangle rectangle = new Rectangle();
//         rectangle.setWidth(5);
//         rectangle.setHeight(10);
//         System.out.println("Rectangle Area: " + rectangle.getArea()); // Expected: 50

//         Rectangle square = new Square();
//         square.setWidth(5);
//         square.setHeight(10);
//         System.out.println("Square Area: " + square.getArea()); // Expected: 50, but Output: 100
//     }
// }

