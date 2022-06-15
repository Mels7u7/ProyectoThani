package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColReclamo", namespace ="ProjectThani")
public final  class StructSdtColReclamo implements Cloneable, java.io.Serializable
{
   public StructSdtColReclamo( )
   {
      this( -1, new ModelContext( StructSdtColReclamo.class ));
   }

   public StructSdtColReclamo( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtColReclamo( java.util.Vector<StructSdtReclamo> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Reclamo",namespace="ProjectThani")
   public java.util.Vector<StructSdtReclamo> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtReclamo> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtReclamo> item = new java.util.Vector<>();
}

