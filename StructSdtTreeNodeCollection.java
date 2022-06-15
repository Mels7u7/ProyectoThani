package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "TreeNodeCollection", namespace ="ProjectThani")
public final  class StructSdtTreeNodeCollection implements Cloneable, java.io.Serializable
{
   public StructSdtTreeNodeCollection( )
   {
      this( -1, new ModelContext( StructSdtTreeNodeCollection.class ));
   }

   public StructSdtTreeNodeCollection( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtTreeNodeCollection( java.util.Vector<StructSdtTreeNodeCollection_TreeNode> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="TreeNode",namespace="ProjectThani")
   public java.util.Vector<StructSdtTreeNodeCollection_TreeNode> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTreeNodeCollection_TreeNode> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTreeNodeCollection_TreeNode> item = new java.util.Vector<>();
}

