package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loaduserkeyvalue extends GXProcedure
{
   public loaduserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loaduserkeyvalue.class ), "" );
   }

   public loaduserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      loaduserkeyvalue.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      loaduserkeyvalue.this.AV11UserCustomizationsKey = aP0;
      loaduserkeyvalue.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12UserCustomizationsValue = AV8Session.getValue(AV11UserCustomizationsKey) ;
      if ( (GXutil.strcmp("", AV12UserCustomizationsValue)==0) )
      {
         GXv_SdtWWPContext1[0] = AV15WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
         AV15WWPContext = GXv_SdtWWPContext1[0] ;
         AV14UserCustomizations.Load(AV15WWPContext.getgxTv_SdtWWPContext_Userid(), AV11UserCustomizationsKey);
         if ( AV14UserCustomizations.Success() )
         {
            AV12UserCustomizationsValue = AV14UserCustomizations.getgxTv_SdtUserCustomizations_Usercustomizationsvalue() ;
         }
         else
         {
            AV12UserCustomizationsValue = "" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = loaduserkeyvalue.this.AV12UserCustomizationsValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12UserCustomizationsValue = "" ;
      AV8Session = httpContext.getWebSession();
      AV15WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV14UserCustomizations = new com.projectthani.wwpbaseobjects.SdtUserCustomizations(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV12UserCustomizationsValue ;
   private String AV11UserCustomizationsKey ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private String[] aP1 ;
   private com.projectthani.wwpbaseobjects.SdtUserCustomizations AV14UserCustomizations ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

