package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccalcularratingporprofesional extends GXProcedure
{
   public prccalcularratingporprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccalcularratingporprofesional.class ), "" );
   }

   public prccalcularratingporprofesional( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 )
   {
      prccalcularratingporprofesional.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             byte[] aP1 )
   {
      prccalcularratingporprofesional.this.AV8ProfesionalId = aP0;
      prccalcularratingporprofesional.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005M3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000GXC1 = P005M3_A40000GXC1[0] ;
         n40000GXC1 = P005M3_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
      }
      pr_default.close(0);
      /* Using cursor P005M5 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40001GXC1 = P005M5_A40001GXC1[0] ;
         n40001GXC1 = P005M5_n40001GXC1[0] ;
      }
      else
      {
         A40001GXC1 = 0 ;
         n40001GXC1 = false ;
      }
      pr_default.close(1);
      /* Using cursor P005M7 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40002GXC1 = P005M7_A40002GXC1[0] ;
         n40002GXC1 = P005M7_n40002GXC1[0] ;
      }
      else
      {
         A40002GXC1 = 0 ;
         n40002GXC1 = false ;
      }
      pr_default.close(2);
      /* Using cursor P005M9 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         A40003GXC1 = P005M9_A40003GXC1[0] ;
         n40003GXC1 = P005M9_n40003GXC1[0] ;
      }
      else
      {
         A40003GXC1 = 0 ;
         n40003GXC1 = false ;
      }
      pr_default.close(3);
      /* Using cursor P005M11 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         A40004GXC1 = P005M11_A40004GXC1[0] ;
         n40004GXC1 = P005M11_n40004GXC1[0] ;
      }
      else
      {
         A40004GXC1 = 0 ;
         n40004GXC1 = false ;
      }
      pr_default.close(4);
      /* Using cursor P005M13 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         A40005GXC1 = P005M13_A40005GXC1[0] ;
         n40005GXC1 = P005M13_n40005GXC1[0] ;
      }
      else
      {
         A40005GXC1 = 0 ;
         n40005GXC1 = false ;
      }
      pr_default.close(5);
      AV10Rating01 = (short)(A40000GXC1) ;
      AV11Rating02 = (short)(A40001GXC1) ;
      AV12Rating03 = (short)(A40002GXC1) ;
      AV13Rating04 = (short)(A40003GXC1) ;
      AV14Rating05 = (short)(A40004GXC1) ;
      AV15RatingNroRegistros = (short)(A40005GXC1) ;
      AV16RatingTotal = DecimalUtil.doubleToDec(((AV10Rating01*1)+(AV11Rating02*2)+(AV12Rating03*3)+(AV13Rating04*4)+(AV14Rating05*5))/ (double) (AV15RatingNroRegistros)) ;
      AV9Rating = (byte)(GXutil.Int( DecimalUtil.decToDouble(AV16RatingTotal))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccalcularratingporprofesional.this.AV9Rating;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P005M3_A40000GXC1 = new int[1] ;
      P005M3_n40000GXC1 = new boolean[] {false} ;
      P005M5_A40001GXC1 = new int[1] ;
      P005M5_n40001GXC1 = new boolean[] {false} ;
      P005M7_A40002GXC1 = new int[1] ;
      P005M7_n40002GXC1 = new boolean[] {false} ;
      P005M9_A40003GXC1 = new int[1] ;
      P005M9_n40003GXC1 = new boolean[] {false} ;
      P005M11_A40004GXC1 = new int[1] ;
      P005M11_n40004GXC1 = new boolean[] {false} ;
      P005M13_A40005GXC1 = new int[1] ;
      P005M13_n40005GXC1 = new boolean[] {false} ;
      AV16RatingTotal = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccalcularratingporprofesional__default(),
         new Object[] {
             new Object[] {
            P005M3_A40000GXC1, P005M3_n40000GXC1
            }
            , new Object[] {
            P005M5_A40001GXC1, P005M5_n40001GXC1
            }
            , new Object[] {
            P005M7_A40002GXC1, P005M7_n40002GXC1
            }
            , new Object[] {
            P005M9_A40003GXC1, P005M9_n40003GXC1
            }
            , new Object[] {
            P005M11_A40004GXC1, P005M11_n40004GXC1
            }
            , new Object[] {
            P005M13_A40005GXC1, P005M13_n40005GXC1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9Rating ;
   private short AV10Rating01 ;
   private short AV11Rating02 ;
   private short AV12Rating03 ;
   private short AV13Rating04 ;
   private short AV14Rating05 ;
   private short AV15RatingNroRegistros ;
   private short Gx_err ;
   private int AV8ProfesionalId ;
   private int A40000GXC1 ;
   private int A40001GXC1 ;
   private int A40002GXC1 ;
   private int A40003GXC1 ;
   private int A40004GXC1 ;
   private int A40005GXC1 ;
   private java.math.BigDecimal AV16RatingTotal ;
   private String scmdbuf ;
   private boolean n40000GXC1 ;
   private boolean n40001GXC1 ;
   private boolean n40002GXC1 ;
   private boolean n40003GXC1 ;
   private boolean n40004GXC1 ;
   private boolean n40005GXC1 ;
   private byte[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005M3_A40000GXC1 ;
   private boolean[] P005M3_n40000GXC1 ;
   private int[] P005M5_A40001GXC1 ;
   private boolean[] P005M5_n40001GXC1 ;
   private int[] P005M7_A40002GXC1 ;
   private boolean[] P005M7_n40002GXC1 ;
   private int[] P005M9_A40003GXC1 ;
   private boolean[] P005M9_n40003GXC1 ;
   private int[] P005M11_A40004GXC1 ;
   private boolean[] P005M11_n40004GXC1 ;
   private int[] P005M13_A40005GXC1 ;
   private boolean[] P005M13_n40005GXC1 ;
}

final  class prccalcularratingporprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005M3", "SELECT COALESCE( T1.[GXC1], 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE ([SGProfesionalProfesionalId] = ?) AND ([RatingProfesionalRating] = 1) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005M5", "SELECT COALESCE( T1.[GXC1], 0) AS GXC2 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE ([SGProfesionalProfesionalId] = ?) AND ([RatingProfesionalRating] = 2) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005M7", "SELECT COALESCE( T1.[GXC1], 0) AS GXC3 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE ([SGProfesionalProfesionalId] = ?) AND ([RatingProfesionalRating] = 3) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005M9", "SELECT COALESCE( T1.[GXC1], 0) AS GXC4 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE ([SGProfesionalProfesionalId] = ?) AND ([RatingProfesionalRating] = 4) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005M11", "SELECT COALESCE( T1.[GXC1], 0) AS GXC5 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE ([SGProfesionalProfesionalId] = ?) AND ([RatingProfesionalRating] = 5) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005M13", "SELECT COALESCE( T1.[GXC1], 0) AS GXC6 FROM (SELECT COUNT(*) AS GXC1 FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

