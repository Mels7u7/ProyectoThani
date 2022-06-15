package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPTransactionContext.Attribute", namespace ="ProjectThani")
public final  class StructSdtWWPTransactionContext_Attribute implements Cloneable, java.io.Serializable
{
   public StructSdtWWPTransactionContext_Attribute( )
   {
      this( -1, new ModelContext( StructSdtWWPTransactionContext_Attribute.class ));
   }

   public StructSdtWWPTransactionContext_Attribute( int remoteHandle ,
                                                    ModelContext context )
   {
   }

   public  StructSdtWWPTransactionContext_Attribute( java.util.Vector<StructSdtWWPTransactionContext_Attribute> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPTransactionContext.Attribute",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPTransactionContext_Attribute> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPTransactionContext_Attribute> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPTransactionContext_Attribute> item = new java.util.Vector<>();
}

