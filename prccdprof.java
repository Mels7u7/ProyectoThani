package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccdprof extends GXProcedure
{
   public prccdprof( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccdprof.class ), "" );
   }

   public prccdprof( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          String[] aP1 )
   {
      prccdprof.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 ,
                             int[] aP2 )
   {
      prccdprof.this.AV8ProfesionalId = aP0;
      prccdprof.this.aP1 = aP1;
      prccdprof.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00662 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P00662_A31ProfesionalId[0] ;
         A40000ProfesionalFoto_GXI = P00662_A40000ProfesionalFoto_GXI[0] ;
         A189ProfesionalFoto = P00662_A189ProfesionalFoto[0] ;
         A182ProfesionalTiempoCita = P00662_A182ProfesionalTiempoCita[0] ;
         AV9ProfesionalFoto = A189ProfesionalFoto ;
         AV14Profesionalfoto_GXI = A40000ProfesionalFoto_GXI ;
         AV10TiempoDeCita = (int)(A182ProfesionalTiempoCita*60) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccdprof.this.AV9ProfesionalFoto;
      this.aP2[0] = prccdprof.this.AV10TiempoDeCita;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProfesionalFoto = "" ;
      scmdbuf = "" ;
      P00662_A31ProfesionalId = new int[1] ;
      P00662_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P00662_A189ProfesionalFoto = new String[] {""} ;
      P00662_A182ProfesionalTiempoCita = new byte[1] ;
      A40000ProfesionalFoto_GXI = "" ;
      A189ProfesionalFoto = "" ;
      AV14Profesionalfoto_GXI = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccdprof__default(),
         new Object[] {
             new Object[] {
            P00662_A31ProfesionalId, P00662_A40000ProfesionalFoto_GXI, P00662_A189ProfesionalFoto, P00662_A182ProfesionalTiempoCita
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A182ProfesionalTiempoCita ;
   private short Gx_err ;
   private int AV8ProfesionalId ;
   private int AV10TiempoDeCita ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A40000ProfesionalFoto_GXI ;
   private String AV14Profesionalfoto_GXI ;
   private String AV9ProfesionalFoto ;
   private String A189ProfesionalFoto ;
   private int[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00662_A31ProfesionalId ;
   private String[] P00662_A40000ProfesionalFoto_GXI ;
   private String[] P00662_A189ProfesionalFoto ;
   private byte[] P00662_A182ProfesionalTiempoCita ;
}

final  class prccdprof__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00662", "SELECT TOP 1 [ProfesionalId], [ProfesionalFoto_GXI], [ProfesionalFoto], [ProfesionalTiempoCita] FROM [Profesional] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(2));
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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

