package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSede", namespace ="ProjectThani")
public final  class StructSdtColSede implements Cloneable, java.io.Serializable
{
   public StructSdtColSede( )
   {
      this( -1, new ModelContext( StructSdtColSede.class ));
   }

   public StructSdtColSede( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtColSede( java.util.Vector<StructSdtSede> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Sede",namespace="ProjectThani")
   public java.util.Vector<StructSdtSede> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSede> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSede> item = new java.util.Vector<>();
}

