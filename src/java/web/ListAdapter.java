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
   List<String> columnList = null;
   public String out="";//**
   
   private void init(){
       Class nodeClass = node.getClass();
       columnList = new ArrayList<>();
       Class[] interfaces = nodeClass.getInterfaces();
       Class nodeInterface = interfaces[interfaces.length-1];
       colom  = new HashMap<Class,List<String>>();
       
        
        if(ExternalProducts.class.equals(nodeInterface)){
             columnList.add("Product");
             colom.put(node.getClass(), columnList);
        }
       
        if(ExternalProduct.class.equals(nodeInterface)){
             
        }
        
        if(DistributionKits.class.equals(nodeInterface)){
             
        }
        
        if(DistributionKit.class.equals(nodeInterface)){
             
        }
        
        
        
   }
   public ListAdapter(Node node) {
        this.node = node; 
    }
    
    
    
    
    public List<String> getColomsName(){
        
        return null;
    }
}
