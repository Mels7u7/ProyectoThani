package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetlistadocostocita extends GXProcedure
{
   public prcgetlistadocostocita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetlistadocostocita.class ), "" );
   }

   public prcgetlistadocostocita( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcgetlistadocostocita.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      prcgetlistadocostocita.this.AV12ProfesionalId = aP0;
      prcgetlistadocostocita.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005C3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P005C3_A31ProfesionalId[0] ;
         A40000GXC1 = P005C3_A40000GXC1[0] ;
         n40000GXC1 = P005C3_n40000GXC1[0] ;
         A40001GXC2 = P005C3_A40001GXC2[0] ;
         n40001GXC2 = P005C3_n40001GXC2[0] ;
         A40000GXC1 = P005C3_A40000GXC1[0] ;
         n40000GXC1 = P005C3_n40000GXC1[0] ;
         A40001GXC2 = P005C3_A40001GXC2[0] ;
         n40001GXC2 = P005C3_n40001GXC2[0] ;
         AV10CostoMin = A40000GXC1 ;
         AV9CostoMax = A40001GXC2 ;
         if ( DecimalUtil.compareTo(AV10CostoMin, AV9CostoMax) == 0 )
         {
            AV8CostoConsulta = "S/." + GXutil.str( AV10CostoMin, 6, 2) ;
         }
         else
         {
            AV8CostoConsulta = "S/." + GXutil.str( AV10CostoMin, 6, 2) + " - " + "S/." + GXutil.str( AV9CostoMax, 6, 2) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetlistadocostocita.this.AV8CostoConsulta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CostoConsulta = "" ;
      scmdbuf = "" ;
      P005C3_A31ProfesionalId = new int[1] ;
      P005C3_A40000GXC1 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P005C3_n40000GXC1 = new boolean[] {false} ;
      P005C3_A40001GXC2 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P005C3_n40001GXC2 = new boolean[] {false} ;
      A40000GXC1 = DecimalUtil.ZERO ;
      A40001GXC2 = DecimalUtil.ZERO ;
      AV10CostoMin = DecimalUtil.ZERO ;
      AV9CostoMax = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetlistadocostocita__default(),
         new Object[] {
             new Object[] {
            P005C3_A31ProfesionalId, P005C3_A40000GXC1, P005C3_n40000GXC1, P005C3_A40001GXC2, P005C3_n40001GXC2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12ProfesionalId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal A40000GXC1 ;
   private java.math.BigDecimal A40001GXC2 ;
   private java.math.BigDecimal AV10CostoMin ;
   private java.math.BigDecimal AV9CostoMax ;
   private String scmdbuf ;
   private boolean n40000GXC1 ;
   private boolean n40001GXC2 ;
   private String AV8CostoConsulta ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005C3_A31ProfesionalId ;
   private java.math.BigDecimal[] P005C3_A40000GXC1 ;
   private boolean[] P005C3_n40000GXC1 ;
   private java.math.BigDecimal[] P005C3_A40001GXC2 ;
   private boolean[] P005C3_n40001GXC2 ;
}

final  class prcgetlistadocostocita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005C3", "SELECT DISTINCT [ProfesionalId], [GXC1], [GXC2] FROM ( SELECT TOP(100) PERCENT T1.[ProfesionalId], COALESCE( T2.[GXC1], 0) AS GXC1, COALESCE( T2.[GXC2], 0) AS GXC2 FROM ([Profesional] T1 LEFT JOIN (SELECT MIN([CostoConsulta]) AS GXC1, [ProfesionalId], MAX([CostoConsulta]) AS GXC2 FROM [ProfesionalEspecialidadSede] GROUP BY [ProfesionalId] ) T2 ON T2.[ProfesionalId] = T1.[ProfesionalId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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
               return;
      }
   }

}

