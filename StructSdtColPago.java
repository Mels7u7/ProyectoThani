package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColPago", namespace ="ProjectThani")
public final  class StructSdtColPago implements Cloneable, java.io.Serializable
{
   public StructSdtColPago( )
   {
      this( -1, new ModelContext( StructSdtColPago.class ));
   }

   public StructSdtColPago( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtColPago( java.util.Vector<StructSdtPago> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Pago",namespace="ProjectThani")
   public java.util.Vector<StructSdtPago> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtPago> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtPago> item = new java.util.Vector<>();
}

