package org.example;

public class EntityMain {

    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {
        EntitySample service = new EntitySample();

        // Create new items
        System.out.println("Adding salt...");
        service.addWarehouseItem(new AnEntity(1, "Salt", 123.45));
        printAllItems(service);

        System.out.println("Adding water...");
        service.addWarehouseItem(new AnEntity(2, "Water", 22));
        printAllItems(service);

        // Update an item
        System.out.println("Correcting mistake: Should be Himalayan Salt.");
        AnEntity updatedSalt = service.findWarehouseItem(1);
        if (updatedSalt != null) {
            updatedSalt.setName("Himalayan Salt");
            updatedSalt.setQuantity(543.21);
            service.updateWarehouseItem(updatedSalt);
        }
        printAllItems(service);

        // Delete an item
        System.out.println("Deleting the Himalayan Salt...");
        service.deleteWarehouseItem(1);
        printAllItems(service);

        // Resetting the database
        System.out.println(RED + "\nResetting the database..." + RESET);
        service.getAllWarehouseItems().forEach(item -> service.deleteWarehouseItem(item.getId()));
        printAllItems(service);

        service.close();
    }

    private static void printAllItems(EntitySample service) {
        System.out.println("------------ Database data ------------");
        service.getAllWarehouseItems().forEach(item ->
                System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getQuantity())
        );
        System.out.println("---------------------------------------");
    }
}
