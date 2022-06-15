package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetconfigvalue extends GXProcedure
{
   public prcgetconfigvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetconfigvalue.class ), "" );
   }

   public prcgetconfigvalue( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      prcgetconfigvalue.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      prcgetconfigvalue.this.AV8ConfigKey = aP0;
      prcgetconfigvalue.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P003Z2 */
      pr_default.execute(0, new Object[] {AV8ConfigKey});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A129ConfigEstadoR = P003Z2_A129ConfigEstadoR[0] ;
         A127ConfigKey = P003Z2_A127ConfigKey[0] ;
         A128ConfigValue = P003Z2_A128ConfigValue[0] ;
         A33ConfigId = P003Z2_A33ConfigId[0] ;
         AV9ConfigValue = A128ConfigValue ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetconfigvalue.this.AV9ConfigValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConfigValue = "" ;
      scmdbuf = "" ;
      P003Z2_A129ConfigEstadoR = new String[] {""} ;
      P003Z2_A127ConfigKey = new String[] {""} ;
      P003Z2_A128ConfigValue = new String[] {""} ;
      P003Z2_A33ConfigId = new short[1] ;
      A129ConfigEstadoR = "" ;
      A127ConfigKey = "" ;
      A128ConfigValue = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetconfigvalue__default(),
         new Object[] {
             new Object[] {
            P003Z2_A129ConfigEstadoR, P003Z2_A127ConfigKey, P003Z2_A128ConfigValue, P003Z2_A33ConfigId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A33ConfigId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A129ConfigEstadoR ;
   private String AV8ConfigKey ;
   private String AV9ConfigValue ;
   private String A127ConfigKey ;
   private String A128ConfigValue ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P003Z2_A129ConfigEstadoR ;
   private String[] P003Z2_A127ConfigKey ;
   private String[] P003Z2_A128ConfigValue ;
   private short[] P003Z2_A33ConfigId ;
}

final  class prcgetconfigvalue__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003Z2", "SELECT [ConfigEstadoR], [ConfigKey], [ConfigValue], [ConfigId] FROM [Config] WHERE ([ConfigKey] = ?) AND ([ConfigEstadoR] = 'A') ORDER BY [ConfigId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

