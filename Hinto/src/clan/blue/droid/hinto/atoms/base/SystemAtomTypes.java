package clan.blue.droid.hinto.atoms.base;

import java.math.BigDecimal;

import clan.blue.droid.hinto.atoms.Chain;
import clan.blue.droid.hinto.atoms.Data;
import clan.blue.droid.hinto.atoms.Link;
import clan.blue.droid.hinto.atoms.Function;

public class SystemAtomTypes {
    public static final Object UnknownType = BigDecimal.ZERO;
    public static final Object DataType = Data.class;
    public static final Object FunctionType = Function.class;
    public static final Object ChainType = Chain.class;
    public static final Object EndType = Link.class;
}
