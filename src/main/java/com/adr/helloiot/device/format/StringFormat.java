//    This file is part of HelloIot.
//
//    HelloIot is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    HelloIot is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with HelloIot.  If not, see <http://www.gnu.org/licenses/>.

package com.adr.helloiot.device.format;

/**
 *
 * @author adrian
 */
public interface StringFormat {
    public String format(byte[] value);
    public byte[] parse(String formattedvalue);
    
    public static StringFormat valueOf(String value) {
        if ("IDENTITY".equals(value)) {
            return StringFormatIdentity.INSTANCE;
        } else if ("INTEGER".equals(value)) {
            return StringFormatDecimal.INTEGER;
        } else if ("HEXADECIMAL".equals(value)) {
            return StringFormatHex.INSTANCE;
        } else if (value.startsWith("DECIMAL/")) {
            return new StringFormatDecimal(value.substring(8));            
        } else {
            throw new IllegalArgumentException("Cannot create StringFormat: " + value);
        }    
    }
}
