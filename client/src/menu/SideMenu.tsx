import {Link} from "react-router-dom";

export const SideMenu = ({menu} : { menu: {page: string, link: string}[] }) => {
    return (
        <aside className="w-[200px] bg-blue-500 text-white px-4 py-6 shadow-md">
            <ul className="flex flex-col gap-6 font-medium">
                {
                    menu && menu.map(tab => {
                        return <Link to={`${tab.link}`}>{tab.page}</Link>;
                    })
                }
            </ul>
        </aside>
    );
};
