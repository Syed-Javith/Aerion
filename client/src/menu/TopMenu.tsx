import {Link} from "react-router-dom";

export const TopMenu = () => {
    return (
        <nav id="top-menu" className="w-full bg-blue-500 py-4 px-6 shadow-md z-10">
            <ul className="flex gap-6 text-white font-medium">
                <Link to={'/admin'}>Admin</Link>
                <Link to={'/inventory'}>Inventory</Link>
                <Link to={'/audit'}>Audit</Link>
                <Link to={'/domains'}>Domains</Link>
            </ul>
        </nav>
    );
};
