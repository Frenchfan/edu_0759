public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера свободных комнат: "+freeRoomsList);
    }
    public void getWifiRooms(){
        String WifiRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWifi()) WifiRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат с Wifi: "+WifiRoomsList);
    }
    public void getWCRooms(){
        String WCRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) WCRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат с WC: "+WCRoomsList);
    }
    public void getEatRooms(){
        String EatRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) EatRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат с включенным завтраком: "+EatRoomsList);
    }
    public void sortby(byte quantity){
        String SortRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getQuantity()==quantity) SortRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат, которые рассчитаны на "+quantity+"постояльцев: "+SortRoomsList);
    }
    public void getRoomdescription(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber){
                System.out.println("Комната "+roomNumber+
                        ": свободна -"+rooms[i].isFree()+", вмещает -"+rooms[i].getQuantity()+
                        " человека/человек, оборудована туалетом: "+rooms[i].isWc()+"," +
                        " завтрак включен: "+rooms[i].isEat()+", Wifi имеется: "+rooms[i].isWifi());
                break;
            } else System.out.println(info);
        }




    }
    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронированна");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }
        System.out.println(info);
    }
    public void freeRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && !room.isFree()){
                room.setFree(true);
                info = ("Комната номер "+roomNumber+" успешно освобождена");
                break;
            }else if(room.getRoomNumber() == roomNumber && room.isFree()){
                info = "Комната "+roomNumber+" уже свободна";
                break;
            }
        }
        System.out.println(info);
    }
}
