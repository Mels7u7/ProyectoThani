package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidarcodigoespecialidad extends GXProcedure
{
   public prcvalidarcodigoespecialidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidarcodigoespecialidad.class ), "" );
   }

   public prcvalidarcodigoespecialidad( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      prcvalidarcodigoespecialidad.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      prcvalidarcodigoespecialidad.this.AV8Codigo = aP0;
      prcvalidarcodigoespecialidad.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9IsValid = false ;
      /* Using cursor P00322 */
      pr_default.execute(0, new Object[] {AV8Codigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A140EspecialidadCodigo = P00322_A140EspecialidadCodigo[0] ;
         A32EspecialidadId = P00322_A32EspecialidadId[0] ;
         AV9IsValid = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcvalidarcodigoespecialidad.this.AV9IsValid;
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
      P00322_A140EspecialidadCodigo = new String[] {""} ;
      P00322_A32EspecialidadId = new short[1] ;
      A140EspecialidadCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidarcodigoespecialidad__default(),
         new Object[] {
             new Object[] {
            P00322_A140EspecialidadCodigo, P00322_A32EspecialidadId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean AV9IsValid ;
   private String AV8Codigo ;
   private String A140EspecialidadCodigo ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00322_A140EspecialidadCodigo ;
   private short[] P00322_A32EspecialidadId ;
}

final  class prcvalidarcodigoespecialidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00322", "SELECT TOP 1 [EspecialidadCodigo], [EspecialidadId] FROM [Especialidad] WHERE [EspecialidadCodigo] = ? ORDER BY [EspecialidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setVarchar(1, (String)parms[0], 4);
               return;
      }
   }

}

