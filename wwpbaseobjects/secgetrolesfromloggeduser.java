package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secgetrolesfromloggeduser extends GXProcedure
{
   public secgetrolesfromloggeduser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secgetrolesfromloggeduser.class ), "" );
   }

   public secgetrolesfromloggeduser( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Short> executeUdp( )
   {
      secgetrolesfromloggeduser.this.aP0 = new GXSimpleCollection[] {new GXSimpleCollection<Short>(Short.class, "internal", "")};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXSimpleCollection<Short>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXSimpleCollection<Short>[] aP0 )
   {
      secgetrolesfromloggeduser.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10SecRoleIdsXML = GXutil.trim( AV12WebSession.getValue("SecGetRolesFromLoggedUser")) ;
      if ( (GXutil.strcmp("", AV10SecRoleIdsXML)==0) )
      {
         GXt_SdtWWPContext1 = AV8WWPContext;
         GXv_SdtWWPContext2[0] = GXt_SdtWWPContext1;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext2) ;
         GXt_SdtWWPContext1 = GXv_SdtWWPContext2[0] ;
         AV8WWPContext = GXt_SdtWWPContext1;
         AV11SecUserId = AV8WWPContext.getgxTv_SdtWWPContext_Userid() ;
         AV9SecRoleIds = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
         /* Using cursor P00212 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV11SecUserId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6SecUserId = P00212_A6SecUserId[0] ;
            A4SecRoleId = P00212_A4SecRoleId[0] ;
            AV9SecRoleIds.add((short)(A4SecRoleId), 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV9SecRoleIds.size() > 0 )
         {
            AV10SecRoleIdsXML = AV9SecRoleIds.toxml(false, true, "Collection", "") ;
            AV12WebSession.setValue("SecGetRolesFromLoggedUser", AV10SecRoleIdsXML);
         }
      }
      else
      {
         AV9SecRoleIds.fromxml(AV10SecRoleIdsXML, null, null);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = secgetrolesfromloggeduser.this.AV9SecRoleIds;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecRoleIds = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV10SecRoleIdsXML = "" ;
      AV12WebSession = httpContext.getWebSession();
      AV8WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXt_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext2 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      P00212_A6SecUserId = new short[1] ;
      P00212_A4SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secgetrolesfromloggeduser__default(),
         new Object[] {
             new Object[] {
            P00212_A6SecUserId, P00212_A4SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11SecUserId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV10SecRoleIdsXML ;
   private GXSimpleCollection<Short> AV9SecRoleIds ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private GXSimpleCollection<Short>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00212_A6SecUserId ;
   private short[] P00212_A4SecRoleId ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXt_SdtWWPContext1 ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext2[] ;
}

final  class secgetrolesfromloggeduser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00212", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

