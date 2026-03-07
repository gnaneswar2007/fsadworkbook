package app;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProductApp {

    public static void main(String[] args) {

        // 🔹 CREATE
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        int laptopId = p1.getId();   // ✅ actual generated ID
        int mouseId  = p2.getId();

        // 🔹 READ
        session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, laptopId);

        if (product != null) {
            System.out.println("Product Name: " + product.getName());
        }
        session.close();

        // 🔹 UPDATE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        product = session.get(Product.class, laptopId);
        if (product != null) {
            product.setPrice(70000);
            product.setQuantity(8);
        }

        tx.commit();   // update is automatic (dirty checking)
        session.close();

        // 🔹 DELETE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product deleteProduct = session.get(Product.class, mouseId);
        if (deleteProduct != null) {
            session.delete(deleteProduct);
        } else {
            System.out.println("Product not found for deletion");
        }

        tx.commit();
        session.close();

        System.out.println("CRUD operations completed successfully.");
    }
}
