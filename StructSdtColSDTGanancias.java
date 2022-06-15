package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTGanancias", namespace ="ProjectThani")
public final  class StructSdtColSDTGanancias implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTGanancias( )
   {
      this( -1, new ModelContext( StructSdtColSDTGanancias.class ));
   }

   public StructSdtColSDTGanancias( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColSDTGanancias( java.util.Vector<StructSdtSDTGanancias> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTGanancias",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTGanancias> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTGanancias> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTGanancias> item = new java.util.Vector<>();
}

