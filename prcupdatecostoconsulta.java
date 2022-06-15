package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcupdatecostoconsulta extends GXProcedure
{
   public prcupdatecostoconsulta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcupdatecostoconsulta.class ), "" );
   }

   public prcupdatecostoconsulta( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 )
   {
      prcupdatecostoconsulta.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        java.math.BigDecimal aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 ,
                             String[] aP5 )
   {
      prcupdatecostoconsulta.this.AV10ProfesionalId = aP0;
      prcupdatecostoconsulta.this.AV8EspecialidadId = aP1;
      prcupdatecostoconsulta.this.AV9SedeId = aP2;
      prcupdatecostoconsulta.this.AV13SedeTipoConsulta = aP3;
      prcupdatecostoconsulta.this.AV12CostoConsulta = aP4;
      prcupdatecostoconsulta.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00692 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10ProfesionalId), Short.valueOf(AV8EspecialidadId), Short.valueOf(AV9SedeId), AV13SedeTipoConsulta});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxt692 = (byte)(0) ;
         A54SedeTipoConsulta = P00692_A54SedeTipoConsulta[0] ;
         A30SedeId = P00692_A30SedeId[0] ;
         A32EspecialidadId = P00692_A32EspecialidadId[0] ;
         A31ProfesionalId = P00692_A31ProfesionalId[0] ;
         A199CostoConsulta = P00692_A199CostoConsulta[0] ;
         A199CostoConsulta = AV12CostoConsulta ;
         gxt692 = (byte)(1) ;
         AV11ErrorMessage = "Se actualizó satisfactoriamente" ;
         /* Using cursor P00693 */
         pr_default.execute(1, new Object[] {A199CostoConsulta, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
         if ( gxt692 == 1 )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "prcupdatecostoconsulta");
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = prcupdatecostoconsulta.this.AV11ErrorMessage;
      Application.commitDataStores(context, remoteHandle, pr_default, "prcupdatecostoconsulta");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11ErrorMessage = "" ;
      scmdbuf = "" ;
      P00692_A54SedeTipoConsulta = new String[] {""} ;
      P00692_A30SedeId = new short[1] ;
      P00692_A32EspecialidadId = new short[1] ;
      P00692_A31ProfesionalId = new int[1] ;
      P00692_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A54SedeTipoConsulta = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcupdatecostoconsulta__default(),
         new Object[] {
             new Object[] {
            P00692_A54SedeTipoConsulta, P00692_A30SedeId, P00692_A32EspecialidadId, P00692_A31ProfesionalId, P00692_A199CostoConsulta
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte gxt692 ;
   private short AV8EspecialidadId ;
   private short AV9SedeId ;
   private short A30SedeId ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV10ProfesionalId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal AV12CostoConsulta ;
   private java.math.BigDecimal A199CostoConsulta ;
   private String AV13SedeTipoConsulta ;
   private String scmdbuf ;
   private String A54SedeTipoConsulta ;
   private String AV11ErrorMessage ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00692_A54SedeTipoConsulta ;
   private short[] P00692_A30SedeId ;
   private short[] P00692_A32EspecialidadId ;
   private int[] P00692_A31ProfesionalId ;
   private java.math.BigDecimal[] P00692_A199CostoConsulta ;
}

final  class prcupdatecostoconsulta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00692", "SELECT [SedeTipoConsulta], [SedeId], [EspecialidadId], [ProfesionalId], [CostoConsulta] FROM [ProfesionalEspecialidadSede] WITH (UPDLOCK) WHERE [ProfesionalId] = ? and [EspecialidadId] = ? and [SedeId] = ? and [SedeTipoConsulta] = ? ORDER BY [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00693", "UPDATE [ProfesionalEspecialidadSede] SET [CostoConsulta]=?  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 1);
               return;
      }
   }

}

