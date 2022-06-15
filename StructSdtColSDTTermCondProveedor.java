package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTTermCondProveedor", namespace ="ProjectThani")
public final  class StructSdtColSDTTermCondProveedor implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTTermCondProveedor( )
   {
      this( -1, new ModelContext( StructSdtColSDTTermCondProveedor.class ));
   }

   public StructSdtColSDTTermCondProveedor( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColSDTTermCondProveedor( java.util.Vector<StructSdtSDTTermCondProveedor> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTTermCondProveedor",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTTermCondProveedor> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTTermCondProveedor> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTTermCondProveedor> item = new java.util.Vector<>();
}

