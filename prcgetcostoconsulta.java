package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetcostoconsulta extends GXProcedure
{
   public prcgetcostoconsulta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetcostoconsulta.class ), "" );
   }

   public prcgetcostoconsulta( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 ,
                              String aP3 ,
                              java.math.BigDecimal[] aP4 )
   {
      prcgetcostoconsulta.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             boolean[] aP5 )
   {
      prcgetcostoconsulta.this.AV10ProfesionalId = aP0;
      prcgetcostoconsulta.this.AV11EspecialidadId = aP1;
      prcgetcostoconsulta.this.AV8SedeId = aP2;
      prcgetcostoconsulta.this.AV12SedeTipoConsulta = aP3;
      prcgetcostoconsulta.this.aP4 = aP4;
      prcgetcostoconsulta.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13isExist = false ;
      /* Using cursor P006B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10ProfesionalId), Short.valueOf(AV11EspecialidadId), Short.valueOf(AV8SedeId), AV12SedeTipoConsulta});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A54SedeTipoConsulta = P006B2_A54SedeTipoConsulta[0] ;
         A30SedeId = P006B2_A30SedeId[0] ;
         A32EspecialidadId = P006B2_A32EspecialidadId[0] ;
         A31ProfesionalId = P006B2_A31ProfesionalId[0] ;
         A199CostoConsulta = P006B2_A199CostoConsulta[0] ;
         OV9CostoConsulta = AV9CostoConsulta ;
         AV9CostoConsulta = A199CostoConsulta ;
         AV13isExist = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = prcgetcostoconsulta.this.AV9CostoConsulta;
      this.aP5[0] = prcgetcostoconsulta.this.AV13isExist;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      scmdbuf = "" ;
      P006B2_A54SedeTipoConsulta = new String[] {""} ;
      P006B2_A30SedeId = new short[1] ;
      P006B2_A32EspecialidadId = new short[1] ;
      P006B2_A31ProfesionalId = new int[1] ;
      P006B2_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A54SedeTipoConsulta = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      OV9CostoConsulta = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetcostoconsulta__default(),
         new Object[] {
             new Object[] {
            P006B2_A54SedeTipoConsulta, P006B2_A30SedeId, P006B2_A32EspecialidadId, P006B2_A31ProfesionalId, P006B2_A199CostoConsulta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EspecialidadId ;
   private short AV8SedeId ;
   private short A30SedeId ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV10ProfesionalId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal AV9CostoConsulta ;
   private java.math.BigDecimal A199CostoConsulta ;
   private java.math.BigDecimal OV9CostoConsulta ;
   private String AV12SedeTipoConsulta ;
   private String scmdbuf ;
   private String A54SedeTipoConsulta ;
   private boolean AV13isExist ;
   private boolean[] aP5 ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P006B2_A54SedeTipoConsulta ;
   private short[] P006B2_A30SedeId ;
   private short[] P006B2_A32EspecialidadId ;
   private int[] P006B2_A31ProfesionalId ;
   private java.math.BigDecimal[] P006B2_A199CostoConsulta ;
}

final  class prcgetcostoconsulta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006B2", "SELECT [SedeTipoConsulta], [SedeId], [EspecialidadId], [ProfesionalId], [CostoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? and [EspecialidadId] = ? and [SedeId] = ? and [SedeTipoConsulta] = ? ORDER BY [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

