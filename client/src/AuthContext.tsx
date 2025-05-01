import {createContext, ReactNode, useState} from "react";
import User from "./models/User";

export interface AuthContextType {
    user: User | null;
    setUser: (user: User | null) => void;
}

export const UserContext = createContext<AuthContextType>({
    user: null,
    setUser: () => {},
});

export const AuthContext = ({children} : { children: ReactNode}) => {

    const [user, setUser] = useState<User | null>(null);

    return (
        <UserContext.Provider value={{user, setUser}} >
            {children}
        </UserContext.Provider>
    );
};
