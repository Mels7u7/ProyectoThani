package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCita", namespace ="ProjectThani")
public final  class StructSdtColCita implements Cloneable, java.io.Serializable
{
   public StructSdtColCita( )
   {
      this( -1, new ModelContext( StructSdtColCita.class ));
   }

   public StructSdtColCita( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtColCita( java.util.Vector<StructSdtCita> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Cita",namespace="ProjectThani")
   public java.util.Vector<StructSdtCita> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCita> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCita> item = new java.util.Vector<>();
}

