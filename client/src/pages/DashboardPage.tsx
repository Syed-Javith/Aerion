import {useContext} from "react";
import {UserContext} from "../AuthContext";

export const DashboardPage = () => {

    const { user } = useContext(UserContext);

    return (
        <>
            {user?.email}
        </>
    );
};
