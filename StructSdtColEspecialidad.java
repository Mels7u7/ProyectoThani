package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColEspecialidad", namespace ="ProjectThani")
public final  class StructSdtColEspecialidad implements Cloneable, java.io.Serializable
{
   public StructSdtColEspecialidad( )
   {
      this( -1, new ModelContext( StructSdtColEspecialidad.class ));
   }

   public StructSdtColEspecialidad( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColEspecialidad( java.util.Vector<StructSdtEspecialidad> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Especialidad",namespace="ProjectThani")
   public java.util.Vector<StructSdtEspecialidad> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtEspecialidad> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtEspecialidad> item = new java.util.Vector<>();
}

