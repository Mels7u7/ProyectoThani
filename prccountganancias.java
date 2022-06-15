package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccountganancias extends GXProcedure
{
   public prccountganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccountganancias.class ), "" );
   }

   public prccountganancias( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 )
   {
      prccountganancias.this.aP1 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        java.math.BigDecimal[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             java.math.BigDecimal[] aP1 )
   {
      prccountganancias.this.AV11ProfesionalId = aP0;
      prccountganancias.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12TotalGanacias = DecimalUtil.doubleToDec(0) ;
      /* Using cursor P008C2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A139DisponibilidadEstadoCita = P008C2_A139DisponibilidadEstadoCita[0] ;
         A31ProfesionalId = P008C2_A31ProfesionalId[0] ;
         A34DisponibilidadId = P008C2_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P008C2_n34DisponibilidadId[0] ;
         AV13DisponibilidadId = A34DisponibilidadId ;
         /* Using cursor P008C3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV13DisponibilidadId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A21SGCitaDisponibilidadId = P008C3_A21SGCitaDisponibilidadId[0] ;
            A19CitaId = P008C3_A19CitaId[0] ;
            n19CitaId = P008C3_n19CitaId[0] ;
            AV8GananciasItem = (com.projectthani.SdtSDTGanancias)new com.projectthani.SdtSDTGanancias(remoteHandle, context);
            AV8GananciasItem.setgxTv_SdtSDTGanancias_Id( A19CitaId );
            AV10GananciasList.add(AV8GananciasItem, 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV18GXV1 = 1 ;
      while ( AV18GXV1 <= AV10GananciasList.size() )
      {
         AV9GananciasItemm = (com.projectthani.SdtSDTGanancias)((com.projectthani.SdtSDTGanancias)AV10GananciasList.elementAt(-1+AV18GXV1));
         /* Using cursor P008C5 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV9GananciasItemm.getgxTv_SdtSDTGanancias_Id())});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A47PagoId = P008C5_A47PagoId[0] ;
            A34DisponibilidadId = P008C5_A34DisponibilidadId[0] ;
            n34DisponibilidadId = P008C5_n34DisponibilidadId[0] ;
            A19CitaId = P008C5_A19CitaId[0] ;
            n19CitaId = P008C5_n19CitaId[0] ;
            A40000GXC1 = P008C5_A40000GXC1[0] ;
            n40000GXC1 = P008C5_n40000GXC1[0] ;
            A40000GXC1 = P008C5_A40000GXC1[0] ;
            n40000GXC1 = P008C5_n40000GXC1[0] ;
            AV12TotalGanacias = AV12TotalGanacias.add((A40000GXC1)) ;
            pr_default.readNext(2);
         }
         pr_default.close(2);
         AV18GXV1 = (int)(AV18GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccountganancias.this.AV12TotalGanacias;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12TotalGanacias = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P008C2_A139DisponibilidadEstadoCita = new String[] {""} ;
      P008C2_A31ProfesionalId = new int[1] ;
      P008C2_A34DisponibilidadId = new int[1] ;
      P008C2_n34DisponibilidadId = new boolean[] {false} ;
      A139DisponibilidadEstadoCita = "" ;
      P008C3_A21SGCitaDisponibilidadId = new int[1] ;
      P008C3_A19CitaId = new int[1] ;
      P008C3_n19CitaId = new boolean[] {false} ;
      AV8GananciasItem = new com.projectthani.SdtSDTGanancias(remoteHandle, context);
      AV10GananciasList = new GXBaseCollection<com.projectthani.SdtSDTGanancias>(com.projectthani.SdtSDTGanancias.class, "SDTGanancias", "ProjectThani", remoteHandle);
      AV9GananciasItemm = new com.projectthani.SdtSDTGanancias(remoteHandle, context);
      P008C5_A47PagoId = new int[1] ;
      P008C5_A34DisponibilidadId = new int[1] ;
      P008C5_n34DisponibilidadId = new boolean[] {false} ;
      P008C5_A19CitaId = new int[1] ;
      P008C5_n19CitaId = new boolean[] {false} ;
      P008C5_A40000GXC1 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P008C5_n40000GXC1 = new boolean[] {false} ;
      A40000GXC1 = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccountganancias__default(),
         new Object[] {
             new Object[] {
            P008C2_A139DisponibilidadEstadoCita, P008C2_A31ProfesionalId, P008C2_A34DisponibilidadId
            }
            , new Object[] {
            P008C3_A21SGCitaDisponibilidadId, P008C3_A19CitaId
            }
            , new Object[] {
            P008C5_A47PagoId, P008C5_A34DisponibilidadId, P008C5_n34DisponibilidadId, P008C5_A19CitaId, P008C5_n19CitaId, P008C5_A40000GXC1, P008C5_n40000GXC1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11ProfesionalId ;
   private int A31ProfesionalId ;
   private int A34DisponibilidadId ;
   private int AV13DisponibilidadId ;
   private int A21SGCitaDisponibilidadId ;
   private int A19CitaId ;
   private int AV18GXV1 ;
   private int A47PagoId ;
   private java.math.BigDecimal AV12TotalGanacias ;
   private java.math.BigDecimal A40000GXC1 ;
   private String scmdbuf ;
   private boolean n34DisponibilidadId ;
   private boolean n19CitaId ;
   private boolean n40000GXC1 ;
   private String A139DisponibilidadEstadoCita ;
   private java.math.BigDecimal[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P008C2_A139DisponibilidadEstadoCita ;
   private int[] P008C2_A31ProfesionalId ;
   private int[] P008C2_A34DisponibilidadId ;
   private boolean[] P008C2_n34DisponibilidadId ;
   private int[] P008C3_A21SGCitaDisponibilidadId ;
   private int[] P008C3_A19CitaId ;
   private boolean[] P008C3_n19CitaId ;
   private int[] P008C5_A47PagoId ;
   private int[] P008C5_A34DisponibilidadId ;
   private boolean[] P008C5_n34DisponibilidadId ;
   private int[] P008C5_A19CitaId ;
   private boolean[] P008C5_n19CitaId ;
   private java.math.BigDecimal[] P008C5_A40000GXC1 ;
   private boolean[] P008C5_n40000GXC1 ;
   private GXBaseCollection<com.projectthani.SdtSDTGanancias> AV10GananciasList ;
   private com.projectthani.SdtSDTGanancias AV8GananciasItem ;
   private com.projectthani.SdtSDTGanancias AV9GananciasItemm ;
}

final  class prccountganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008C2", "SELECT [DisponibilidadEstadoCita], [ProfesionalId], [DisponibilidadId] FROM [Disponibilidad] WHERE ([ProfesionalId] = ?) AND ([DisponibilidadEstadoCita] = 'O') ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008C3", "SELECT [SGCitaDisponibilidadId], [CitaId] FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ORDER BY [SGCitaDisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008C5", "SELECT T1.[PagoId], T1.[DisponibilidadId], T1.[CitaId], COALESCE( T2.[GXC1], 0) AS GXC1 FROM ([Pago] T1 LEFT JOIN (SELECT SUM([PagoMonto]) AS GXC1, [PagoId], [DisponibilidadId] FROM [Pago] GROUP BY [PagoId], [DisponibilidadId] ) T2 ON T2.[PagoId] = T1.[PagoId] AND T2.[DisponibilidadId] = T1.[DisponibilidadId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

