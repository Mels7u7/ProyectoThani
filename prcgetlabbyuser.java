package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetlabbyuser extends GXProcedure
{
   public prcgetlabbyuser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetlabbyuser.class ), "" );
   }

   public prcgetlabbyuser( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      prcgetlabbyuser.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      prcgetlabbyuser.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      /* Using cursor P003N2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8WWPContext.getgxTv_SdtWWPContext_Userid())});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6SecUserId = P003N2_A6SecUserId[0] ;
         A40LaboratorioId = P003N2_A40LaboratorioId[0] ;
         AV9LaboratorioId = A40LaboratorioId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcgetlabbyuser.this.AV9LaboratorioId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      P003N2_A6SecUserId = new short[1] ;
      P003N2_A40LaboratorioId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetlabbyuser__default(),
         new Object[] {
             new Object[] {
            P003N2_A6SecUserId, P003N2_A40LaboratorioId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9LaboratorioId ;
   private short A6SecUserId ;
   private short A40LaboratorioId ;
   private short Gx_err ;
   private String scmdbuf ;
   private short[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P003N2_A6SecUserId ;
   private short[] P003N2_A40LaboratorioId ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class prcgetlabbyuser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003N2", "SELECT [SecUserId], [LaboratorioId] FROM [LaboratorioLaboratorioUsuarios] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

