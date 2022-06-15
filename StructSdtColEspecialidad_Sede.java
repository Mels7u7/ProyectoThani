package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColEspecialidad.Sede", namespace ="ProjectThani")
public final  class StructSdtColEspecialidad_Sede implements Cloneable, java.io.Serializable
{
   public StructSdtColEspecialidad_Sede( )
   {
      this( -1, new ModelContext( StructSdtColEspecialidad_Sede.class ));
   }

   public StructSdtColEspecialidad_Sede( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtColEspecialidad_Sede( java.util.Vector<StructSdtEspecialidad_Sede> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Especialidad.Sede",namespace="ProjectThani")
   public java.util.Vector<StructSdtEspecialidad_Sede> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtEspecialidad_Sede> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtEspecialidad_Sede> item = new java.util.Vector<>();
}

