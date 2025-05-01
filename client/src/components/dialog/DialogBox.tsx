import {JSX, useContext} from "react";
import {FiX} from "react-icons/fi";
import {DialogContext} from "../../UIContext";

export const DialogBox = ({title, description}: { title: string, description: JSX.Element }) => {

    const dialogContext = useContext(DialogContext);

    return (
        <div
            className={"absolute top-[6.25%] left-[25%] w-1/2 h-1/2 bg-white z-[1000] shadow-gray-200 pb-6 rounded-lg shadow-lg"}>
            <div>
                <div className={"p-2 bg-blue-200 mb-10 flex justify-between"}>
                    <span className="text-2xl">{title}</span>
                    <FiX className={"mt-0.5 cursor-pointer"} onClick={() => {
                        dialogContext.setDialogTitle("");
                        dialogContext.setDialogContent("");
                        dialogContext.setDialogOpen(false);
                    }} />
                </div>
                <div className={"pl-6"}>
                    {description}
                </div>
            </div>
        </div>
    );
};
