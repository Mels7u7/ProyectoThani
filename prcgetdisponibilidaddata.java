package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetdisponibilidaddata extends GXProcedure
{
   public prcgetdisponibilidaddata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetdisponibilidaddata.class ), "" );
   }

   public prcgetdisponibilidaddata( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             int[] aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      prcgetdisponibilidaddata.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        int[] aP1 ,
                        short[] aP2 ,
                        short[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             int[] aP1 ,
                             short[] aP2 ,
                             short[] aP3 ,
                             String[] aP4 )
   {
      prcgetdisponibilidaddata.this.AV8DisponibilidadId = aP0;
      prcgetdisponibilidaddata.this.aP1 = aP1;
      prcgetdisponibilidaddata.this.aP2 = aP2;
      prcgetdisponibilidaddata.this.aP3 = aP3;
      prcgetdisponibilidaddata.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P003S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8DisponibilidadId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A34DisponibilidadId = P003S2_A34DisponibilidadId[0] ;
         A31ProfesionalId = P003S2_A31ProfesionalId[0] ;
         A35SGSedeDisponibilidadSedeId = P003S2_A35SGSedeDisponibilidadSedeId[0] ;
         A32EspecialidadId = P003S2_A32EspecialidadId[0] ;
         A298DisponibilidadTipoCita = P003S2_A298DisponibilidadTipoCita[0] ;
         AV12ProfesionalId = A31ProfesionalId ;
         AV10SedeId = A35SGSedeDisponibilidadSedeId ;
         AV11EspecialidadId = A32EspecialidadId ;
         AV9DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetdisponibilidaddata.this.AV12ProfesionalId;
      this.aP2[0] = prcgetdisponibilidaddata.this.AV10SedeId;
      this.aP3[0] = prcgetdisponibilidaddata.this.AV11EspecialidadId;
      this.aP4[0] = prcgetdisponibilidaddata.this.AV9DisponibilidadTipoCita;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9DisponibilidadTipoCita = "" ;
      scmdbuf = "" ;
      P003S2_A34DisponibilidadId = new int[1] ;
      P003S2_A31ProfesionalId = new int[1] ;
      P003S2_A35SGSedeDisponibilidadSedeId = new short[1] ;
      P003S2_A32EspecialidadId = new short[1] ;
      P003S2_A298DisponibilidadTipoCita = new String[] {""} ;
      A298DisponibilidadTipoCita = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetdisponibilidaddata__default(),
         new Object[] {
             new Object[] {
            P003S2_A34DisponibilidadId, P003S2_A31ProfesionalId, P003S2_A35SGSedeDisponibilidadSedeId, P003S2_A32EspecialidadId, P003S2_A298DisponibilidadTipoCita
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10SedeId ;
   private short AV11EspecialidadId ;
   private short A35SGSedeDisponibilidadSedeId ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV8DisponibilidadId ;
   private int AV12ProfesionalId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private String AV9DisponibilidadTipoCita ;
   private String scmdbuf ;
   private String A298DisponibilidadTipoCita ;
   private String[] aP4 ;
   private int[] aP1 ;
   private short[] aP2 ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P003S2_A34DisponibilidadId ;
   private int[] P003S2_A31ProfesionalId ;
   private short[] P003S2_A35SGSedeDisponibilidadSedeId ;
   private short[] P003S2_A32EspecialidadId ;
   private String[] P003S2_A298DisponibilidadTipoCita ;
}

final  class prcgetdisponibilidaddata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003S2", "SELECT [DisponibilidadId], [ProfesionalId], [SGSedeDisponibilidadSedeId], [EspecialidadId], [DisponibilidadTipoCita] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
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

