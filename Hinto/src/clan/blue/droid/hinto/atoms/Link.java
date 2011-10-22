package clan.blue.droid.hinto.atoms;

import java.math.BigDecimal;

import android.util.Log;
import clan.blue.droid.hinto.atoms.base.SystemAtomTypes;

public interface Link extends Data {
    public static final Link End = new Link() {
        @Override
        public String getValue() {
            return BigDecimal.ZERO.toString();
        }

        @Override
        public Data getNext() {
            return this;
        }

        @Override
        public Data attach(Data next) {
            // Not sure if this is a full-blown error or not; opting for logging as a warning, for now.
            Log.i(Link.class.getSimpleName(), "Link.End.attach() - can't attach to Link.End; input ignored.");
            return this;
        }

        @Override public Object getType() { return SystemAtomTypes.EndType; }
    };
    
    public static final class Util {
        public static boolean isLinkEnd(Data link) { return link == Link.End; }
        public static boolean isNotLinkEnd(Data link) { return link != Link.End; }
    }
    
    public static final class Tool {
    }
    
}
