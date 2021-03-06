/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.radixware.web.manager.DistributionKit;
import org.radixware.web.manager.DistributionKits;
import org.radixware.web.manager.ExternalProduct;
import org.radixware.web.manager.ExternalProducts;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;

/**
 *
 * @author Денис
 */
public class ListAdapter {
   private Node node;
   private Map<Class ,List<String>> colom = null;
   private Map<Class ,String> rowReference = null;
   List<String> columnList = null;
   public String out="";//**
   
    public static Class getNodeClass(Node node){
         Class nodeClass = node.getClass();
         Class[] interfaces = nodeClass.getInterfaces();
         Class nodeInterface = interfaces[interfaces.length-1];
         
         if(Project.class.equals(nodeInterface)) return Project.class;
         if(ExternalProducts.class.equals(nodeInterface)) return ExternalProducts.class;
         if(ExternalProduct.class.equals(nodeInterface)) return ExternalProduct.class;
         if(DistributionKits.class.equals(nodeInterface)) return DistributionKits.class;
         if(DistributionKit.class.equals(nodeInterface)) return DistributionKit.class;
         
         return null;
    }
   private void init(){
       Class nodeInterface =  getNodeClass(node);
       columnList = new ArrayList<>();
       colom  = new HashMap<Class,List<String>>();
       rowReference  = new HashMap<Class,String>();
        
        if(ExternalProducts.class.equals(nodeInterface)){
             columnList.add("Product");
             colom.put(node.getClass(), columnList);
             rowReference.put(node.getClass(),"list.jsp");
        }
        
        if(ExternalProduct.class.equals(nodeInterface)){
             columnList.add("Version");
             
             colom.put(node.getClass(), columnList);
             
             rowReference.put(node.getClass(), "distrib.jsp");
        }
        
        
        
        
        
   }
   public ListAdapter(Node node) {
        this.node = node; 
    }
   
    public List<String> getColomsName(){
        if (colom == null) init();
        return  colom.get(node.getClass());
    }
    
    public String getRowReference(){
        if (rowReference == null) init();
        return  rowReference.get(node.getClass());
    }
}
