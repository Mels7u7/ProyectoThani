package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "GoogleDocsResult.Doc", namespace ="DVelop.Extensions.GoogleDocs")
public final  class StructSdtGoogleDocsResult_Doc implements Cloneable, java.io.Serializable
{
   public StructSdtGoogleDocsResult_Doc( )
   {
      this( -1, new ModelContext( StructSdtGoogleDocsResult_Doc.class ));
   }

   public StructSdtGoogleDocsResult_Doc( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtGoogleDocsResult_Doc( java.util.Vector<StructSdtGoogleDocsResult_Doc> value )
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

   @javax.xml.bind.annotation.XmlElement(name="GoogleDocsResult.Doc",namespace="DVelop.Extensions.GoogleDocs")
   public java.util.Vector<StructSdtGoogleDocsResult_Doc> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGoogleDocsResult_Doc> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGoogleDocsResult_Doc> item = new java.util.Vector<>();
}

