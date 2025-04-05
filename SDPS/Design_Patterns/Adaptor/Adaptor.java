
public class Adaptor {
    public interface USB {
        void connectWithUSB();
    }    

    public interface TypeC {
        void connectWithTypeC();
    }

    public static class USBToTypeCAdaptor implements TypeC {
        private USB usbDevice;

        public USBToTypeCAdaptor(USB usbDevice) {
            this.usbDevice = usbDevice;
        }

        @Override
        public void connectWithTypeC() {
            System.out.println("Adapting USB to Type-C...");
            usbDevice.connectWithUSB(); // Call the USB device's method
        }
    }

    public static class USBDevice implements USB {
        @Override
        public void connectWithUSB() {
            System.out.println("Connected with USB.");
        }
    }

    public static void main(String args[]){
        USB usbDevice = new USBDevice(); //existing USB device (Adaptee)
        TypeC typeCAdaptor = new USBToTypeCAdaptor(usbDevice); // Adaptor implementing Target interface which is TypeC
        // Now we can use the TypeC interface to connect with the USB device
        
        typeCAdaptor.connectWithTypeC(); // This will adapt the connection
    }
}
