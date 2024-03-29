package org.datanucleus.samples.jdo.tutorial;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

/**
 * Controlling application for the DataNucleus Tutorial using JDO.
 * Relies on the user defining a file "datanucleus.properties" to be in the CLASSPATH
 * and to include the JDO properties for the DataNucleus PersistenceManager.
 */
public class Main
{
    public static void main(String args[])
    {
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("ProMol");

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        Molecule mol = new Molecule("molecule1", "ccc", 1);
        try
        {
            tx.begin();
            System.out.println("new molecule");
            pm.makePersistent(mol);
            mol.setName("blblbl");
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception persisting data : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        // System.out.println("");

        // // Basic Extent of all Products
        // pm = pmf.getPersistenceManager();
        // tx = pm.currentTransaction();
        // try
        // {
        //     tx.begin();
        //     System.out.println("Retrieving Extent for Products");
        //     Extent e = pm.getExtent(Product.class, true);
        //     Iterator iter = e.iterator();
        //     while (iter.hasNext())
        //     {
        //         Object obj = iter.next();
        //         System.out.println(">  " + obj);
        //     }
        //     tx.commit();
        // }
        // catch (Exception e)
        // {
        //     System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        // }
        // finally
        // {
        //     if (tx.isActive())
        //     {
        //         tx.rollback();
        //     }
        //     pm.close();
        // }
        // System.out.println("");

        // // Perform some query operations
        // pm = pmf.getPersistenceManager();
        // tx = pm.currentTransaction();
        // try
        // {
        //     tx.begin();
        //     System.out.println("Executing Query for Products with price below 150.00");
        //     Query q=pm.newQuery("SELECT FROM " + Product.class.getName() + 
        //         " WHERE price < 150.00 ORDER BY price ASC");
        //     List<Product> products = (List<Product>)q.execute();
        //     Iterator<Product> iter = products.iterator();
        //     while (iter.hasNext())
        //     {
        //         Product p = iter.next();
        //         System.out.println(">  " + p);

        //         // Give an example of an update
        //         if (p instanceof Book)
        //         {
        //             Book b = (Book)p;
        //             b.setDescription("This book has been reduced in price!");
        //         }
        //     }

        //     tx.commit();
        // }
        // catch (Exception e)
        // {
        //     System.out.println("Exception performing queries : " + e.getMessage());
        // }
        // finally
        // {
        //     if (tx.isActive())
        //     {
        //         tx.rollback();
        //     }
        //     pm.close();
        // }
        // System.out.println("");

        // // Clean out the database
        // pm = pmf.getPersistenceManager();
        // tx = pm.currentTransaction();
        // try
        // {
        //     tx.begin();

        //     System.out.println("Retrieving Inventory using its id");
        //     Inventory inv = (Inventory)pm.getObjectById(inventoryId);

        //     System.out.println("Clearing out Inventory");
        //     inv.getProducts().clear();

        //     System.out.println("Deleting Inventory");
        //     pm.deletePersistent(inv);

        //     System.out.println("Deleting all products from persistence");
        //     Query q = pm.newQuery(Product.class);
        //     long numberInstancesDeleted = q.deletePersistentAll();
        //     System.out.println("Deleted " + numberInstancesDeleted + " products");

        //     tx.commit();
        // }
        // catch (Exception e)
        // {
        //     System.out.println("Exception cleaning out the database : " + e.getMessage());
        // }
        // finally
        // {
        //     if (tx.isActive())
        //     {
        //         tx.rollback();
        //     }
        //     pm.close();
        // }

        // System.out.println("");
        // System.out.println("End of Tutorial");
        // pmf.close();
    }
}
