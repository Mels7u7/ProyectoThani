package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColPais", namespace ="ProjectThani")
public final  class StructSdtColPais implements Cloneable, java.io.Serializable
{
   public StructSdtColPais( )
   {
      this( -1, new ModelContext( StructSdtColPais.class ));
   }

   public StructSdtColPais( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtColPais( java.util.Vector<StructSdtPais> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Pais",namespace="ProjectThani")
   public java.util.Vector<StructSdtPais> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtPais> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtPais> item = new java.util.Vector<>();
}

