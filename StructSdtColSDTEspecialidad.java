package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTEspecialidad", namespace ="ProjectThani")
public final  class StructSdtColSDTEspecialidad implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTEspecialidad( )
   {
      this( -1, new ModelContext( StructSdtColSDTEspecialidad.class ));
   }

   public StructSdtColSDTEspecialidad( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSDTEspecialidad( java.util.Vector<StructSdtSDTEspecialidad> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTEspecialidad",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTEspecialidad> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTEspecialidad> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTEspecialidad> item = new java.util.Vector<>();
}

