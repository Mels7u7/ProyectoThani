package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class saveuserkeyvalue extends GXProcedure
{
   public saveuserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( saveuserkeyvalue.class ), "" );
   }

   public saveuserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      saveuserkeyvalue.this.AV11UserCustomizationsKey = aP0;
      saveuserkeyvalue.this.AV12UserCustomizationsValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Session.setValue(AV11UserCustomizationsKey, AV12UserCustomizationsValue);
      GXv_SdtWWPContext1[0] = AV14WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV14WWPContext = GXv_SdtWWPContext1[0] ;
      AV13UserCustomizations.Load(AV14WWPContext.getgxTv_SdtWWPContext_Userid(), AV11UserCustomizationsKey);
      if ( ! AV13UserCustomizations.Success() )
      {
         AV13UserCustomizations = (com.projectthani.wwpbaseobjects.SdtUserCustomizations)new com.projectthani.wwpbaseobjects.SdtUserCustomizations( remoteHandle, context);
         AV13UserCustomizations.setgxTv_SdtUserCustomizations_Usercustomizationsid( AV14WWPContext.getgxTv_SdtWWPContext_Userid() );
         AV13UserCustomizations.setgxTv_SdtUserCustomizations_Usercustomizationskey( AV11UserCustomizationsKey );
      }
      AV13UserCustomizations.setgxTv_SdtUserCustomizations_Usercustomizationsvalue( AV12UserCustomizationsValue );
      AV13UserCustomizations.Save();
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.saveuserkeyvalue");
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Session = httpContext.getWebSession();
      AV14WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV13UserCustomizations = new com.projectthani.wwpbaseobjects.SdtUserCustomizations(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.saveuserkeyvalue__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV12UserCustomizationsValue ;
   private String AV11UserCustomizationsKey ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private com.projectthani.wwpbaseobjects.SdtUserCustomizations AV13UserCustomizations ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV14WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class saveuserkeyvalue__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

