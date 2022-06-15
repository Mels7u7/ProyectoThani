package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWPTransactionContext", namespace ="ProjectThani")
public final  class StructSdtWWPTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtWWPTransactionContext( )
   {
      this( -1, new ModelContext( StructSdtWWPTransactionContext.class ));
   }

   public StructSdtWWPTransactionContext( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtWWPTransactionContext( java.util.Vector<StructSdtWWPTransactionContext> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPTransactionContext",namespace="ProjectThani")
   public java.util.Vector<StructSdtWWPTransactionContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPTransactionContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPTransactionContext> item = new java.util.Vector<>();
}

